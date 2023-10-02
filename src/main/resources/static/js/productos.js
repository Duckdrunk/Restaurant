// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarProductos();
    cargarCategorias();
    $('#productos').DataTable();
    
});
  
async function cargarProductos()
{
    const request = await fetch('api/productos', {
    method: 'GET',
    headers:getHeaders()
    });
    const productos = await request.json();

    var listadoHtml='';
    for(let producto of productos ){
        let productosHtml = '<tr><td>'+  producto.nombre + '</td><td>' +producto.descripcion 
                            +'</td><td>' + producto.precio +'</td><td><img src="' +producto.imagen  
                            +'"></td><td>' + producto.idcategoria +'</td></tr>';         
  
        listadoHtml += productosHtml;
    }
    document.querySelector('#productos tbody').outerHTML = listadoHtml;
}
  
function getHeaders(){
    return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
    };
}

async function cargarCategorias() {
    const request = await fetch('api/categorias', {
        method: 'GET',
        headers: getHeaders()
    });
    const categorias = await request.json();
    var listadoHtml = '';

    for (let categoria of categorias) {
        let categoriasHtml = '<option value="' + categoria.idcategoria + '">' + categoria.nombre + '</option>';
        listadoHtml += categoriasHtml;
    }

    const categoriasSelect = document.querySelector('#categorias');

    categoriasSelect.addEventListener("change", function () {
        
        const selectedCategoryId = categoriasSelect.value;

        
        cargarProductosbyCategoria(selectedCategoryId);
    });

    // Establece el contenido HTML del elemento <select>
    categoriasSelect.innerHTML = listadoHtml;
}


async function cargarProductosbyCategoria(idcategoria)
{
    console.log("hola");
    const request = await fetch('api/productos/'+idcategoria, {
        method: 'GET',
        headers:getHeaders()
        });
        const productos = await request.json();
    
        var listadoHtml='';
        //Manejo de error por si no hay productos con esa categoria
        if(productos.length==0){
            listadoHtml='<tr><td></td><td></td><td></td><td></td><td></td><tr>';
        }

        for(let producto of productos ){
            let productosHtml = '<tr><td>'+  producto.nombre + '</td><td>' +producto.descripcion 
                                +'</td><td>' + producto.precio +'</td><td>' +producto.imagen  
                                +'</td><td>' + producto.idcategoria +'</td></tr>';         
      
            listadoHtml += productosHtml;
        }
        
        document.querySelector('#productos tbody').outerHTML = listadoHtml;
}