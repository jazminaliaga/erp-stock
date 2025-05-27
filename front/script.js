document.addEventListener('DOMContentLoaded', () => {
  const lista = document.getElementById('lista-productos');

  fetch('http://localhost:8080/productos') // Ajustá la URL si es necesario
    .then(response => {
      if (!response.ok) throw new Error('Error al obtener productos');
      return response.json();
    })
    .then(data => {
      data.forEach(producto => {
        const li = document.createElement('li');
        li.textContent = `${producto.nombre} — Stock: ${producto.stock}`;
        lista.appendChild(li);
      });
    })
    .catch(error => {
      console.error(error);
      lista.innerHTML = '<li style="color: red;">No se pudo cargar el listado.</li>';
    });
});
