document.addEventListener("DOMContentLoaded", () => {
    fetch('/api/shape')
        .then(response => {
            if (!response.ok) {
                throw new Error(`Server returned HTTP ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const shapeElement = document.getElementById('shapeElement');
            if (!shapeElement) {
                console.warn("Element '#shapeElement' not found in DOM.");
                return;
            }

            console.info('Fetched shape configuration:', data);

            // Set color safely if defined
            if (data.color) {
                shapeElement.style.backgroundColor = data.color;
            }
            
            // Remove previous shape classes to prevent conflicts
            shapeElement.classList.remove('circle', 'square');
            
            // Use optional chaining for safe string evaluation
            const isCircle = data.type?.toLowerCase() === 'circle';
            shapeElement.classList.add(isCircle ? 'circle' : 'square');
        })
        .catch(error => console.error('Error fetching shape configuration:', error));
});