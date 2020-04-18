function del(id) {
    swal({
      title: "Desea eliminar este registro?",
      text: "Once deleted, you will not be able to recover this record!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((Ok) => {
      if (Ok) {
          $.ajax({
              type: "POST",
              url: "/delete/" + id,
              //data: {id: id},
              contentType: "application/json",
              success: function(res) {
                console.log(res)
              }
        });
        swal("Registro borrado exitosamente!", {
          icon: "success",
        }).then((Ok)=> {
            location.href="/";
        })
      } else {
        swal("Acción cancelada!");
      }
    });
}
