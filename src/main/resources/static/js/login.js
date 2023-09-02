function customEnterKey() {

    if(window.event.keyCode == 13) {

      var loginId = $('input[name=userId]').val();
      var loginPw = $('input[name=userPw]').val();

      console.log('loginId = ' + loginId);
      console.log('loginPw = ' + loginPw);

      var obj = {
        userId : loginId,
        userPw : loginPw
      }

      loginProcess(obj);

    }

}


function loginProcess(obj) {

  $.ajax({
      method: 'POST',
      url: '/login/process',
      data:obj,
      success: function(data) {
        location.href="/";
      },
      
      error: function(err) {            
        console.log(err);
      }

    });

}