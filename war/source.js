$(document).ready(function() {

	$("#signinbtn").show();
	$("#signupbtn").show();
	$("#signIn").hide();
	$("#signUp").hide();

	$("#signinbtn").click(function() {
		$("#signUp").hide();
		$("#signIn").toggle();
		$("#signUp").hide();
		
		$("#btn").click(function() {
			var username = $("#username").val();
			var password = $("#pwd").val();
			if (username == "" || username == " ") {
				alert("please enter username");
				return false;
			}
			if (password == "") {
				alert("please enter password");
				return false;
			}

			$.post("Login",

			{
				"username" : username,
				"password" : password
			}, function(result, status, xhr) {
				
				if (result == "true") {
					
					window.location.href = "LastPage1.jsp"
				}

				else
					window.location.href = "LastPage.jsp"

			});

		});
	});
	$("#signupbtn").click(function() {

		console.log("inside signup1")
		$("#signIn").hide();
		$("#signUp").toggle();
		$("#signUpSubmit").click(function() {
			console.log("inside signup2")
			var username = $("#uname").val();
			console.log(username);
			var firstname = $("#firstname").val();
			var lastname = $("#lastname").val();
			var password = $("#password").val();
			var ph_no = $("#ph_no").val();
			var email = $("#email").val();
			if (username == "" || username == " ") {
				alert("please enter username");
				return false;
			}
			if (password == "") {
				alert("please enter password");
				return false;
			}
			console.log("inside sign up username:" + username);
			console.log("inside sign up password:" + password);
			$.get("Register", {
				"username" : username,
				"firstname" : firstname,
				"lastname" : lastname,
				"password" : password,
				"ph_no" : ph_no,
				"email" : email

			}, function(result, status, xhr) {
				if (status == "success") {
					window.location.href = "LastPage.jsp"
				}

			});

		});
	});
});
