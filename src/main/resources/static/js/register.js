// Call the dataTables jQuery plugin
$(document).ready(function() {

    
  });
  
  
  async function registrarUsuarios()
  {
    let datos = {};
    datos.nombre=document.getElementById('txtNombre').value;
    datos.apellido=document.getElementById('txtApellido').value;
    datos.email=document.getElementById('txtEmail').value;
    datos.password=document.getElementById('txtPassword').value;
    
    let repeatPass = document.getElementById('txtRepeatPassword').value;
    if(datos.password!=repeatPass)
    {
      alert('Las contraseñas son diferentes');
      return;
    }
    const request = await fetch('api/usuarios', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
      });
      
      alert("Se creo la cuenta");
      window.location.href='login.html';
  }
  