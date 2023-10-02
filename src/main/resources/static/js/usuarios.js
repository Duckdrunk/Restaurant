// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
    actualizarEmailUsuario();
});

function actualizarEmailUsuario(){
  document.getElementById('txt-email-usuario').outerHTML=localStorage.email;
}


async function cargarUsuarios()
{
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers:getHeaders()
    });
    const usuarios = await request.json();

    var listadoHtml='';
    for(let usuario of usuarios ){
      let btnView = '<a href="#" onclick="getUsuariobyId(' + usuario.idusuario + ')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-eye"></i></a>';

      let btnDelete = '<a href="#" onclick="deleteUsuario(' + usuario.idusuario + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
      
      let telefonotxt = usuario.telefono == null ? '-' : usuario.telefono;

      let usuarioHtml = '<tr><td>'+usuario.nombre + ' ' + usuario.apellido+'</td><td>'
                    + usuario.email+'</td><td>'+ telefonotxt
                    + '</td><td>'+ btnView+'&nbsp&nbsp'+ btnDelete  + '</td></tr>';

      listadoHtml += usuarioHtml;
    }
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

function getHeaders(){
    return {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
    };
}

async function deleteUsuario(idusuario)
{

  if(!confirm('¿Desea eliminar el usuario?'))
  {
    return;
  }

  const request = await fetch('api/usuarios/' + idusuario, {
    method: 'DELETE',
    headers: getHeaders()
  });
  
  location.reload();

}

async function getUsuariobyId(id)
{
  const request = await fetch('api/usuarios/' + id , {
    method: 'GET',
    headers: getHeaders()
  });

  const usuario = request.json;
  console.log(usuario);
}