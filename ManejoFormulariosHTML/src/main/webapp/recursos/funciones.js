function validarForm(form) {
  let usuario  = form.usuario;
  if(usuario.value == "") {
    alert("Debes proporcionar un nombre de usuario");
    usuario.focus();
    usuario.select();
    return false;
  } 

  let password = form.password;
  if(password.value == "" || password.value.length < 8) {
    alert("Debes proporcionar un password de al menos 8 caracteres");
    password.focus();
    password.select();
    return false;
  }

  let tecnologias = form.tecnologia;
  let checkSeleccionado = false;

  for(let i = 0; i < tecnologias.length; i++) {
    if(tecnologias[i].checked) {
      checkSeleccionado = true;
    }
  }

  if(!checkSeleccionado) {
    alert("Debe seleccionar una tecnologia");
    return false;
  }

  let generos = form.genero;
  let radioSeleccionado = false;

  for(let i = 0; i < generos.length; i++) {
    if(generos[i].checked) {
      radioSeleccionado = true;
    }
  }

  if(!radioSeleccionado) {
    alert("Debe seleccionar un genero");
    return false;
  }

  let ocupacion = form.ocupacion;
  if(ocupacion.value == "") {
    alert("Debe seleccionar una ocupacion");
    return false;
  }

  alert("Formulario valido, enviando datos al servidor");
  return true;
}