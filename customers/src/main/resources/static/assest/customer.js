$(document).ready(function() {
	getAllCustomers();
	checkNumber();
	checkEmail();
});

// User can not select future date
var dateControler = {
	currentDate: null
}
$(document).on("keyup blur change input", "#DOB", function() {
	var now = new Date();
	var selectedDate = new Date($(this).val());
	if (selectedDate > now) {
		$(this).val(dateControler.currentDate);
	} else {
		dateControler.currentDate = $(this).val();
	}
});

$("#DOB").on("keyup blur change input", function() {
	var userinput = $("#DOB").val();
	var dob = new Date(userinput);
	var month_diff = Date.now() - dob.getTime();
	var age_dt = new Date(month_diff);
	var year = age_dt.getUTCFullYear();
	var age = Math.abs(year - 1970);
	$("#Age").val(age);
});

// Hide the validation messages
function validationErorMessages() {
	$("#firstName-error").html("");
	$("#lastName-error").html("");
	$("#DOB-error").html("");
	$("#addressOne-error").html("");
	$("#addressTwo-error").html("");
	$("#Age-error").html("");
	$("#mobileNumber-error").html("");
	$("#email-error").html("");
}
// Hide the errors message
function hideMobileNumber() {
	$("#mobileNumberError").html("");
}
function hideEmailId() {
	$("#emailError").html("");
}

// Hide error meassge and reset data with get all customer
function remvoeAndResetForm() {
	validationErorMessages();
	hideMobileNumber();
	hideEmailId();
	resetForm();
	getAllCustomers();
}

// Check mobile number is exist or not
function checkNumber() {
	$("#mobileNumber").on("keyup blur change input", function() {
		var formData = {
			id: $("#customerid").val(),
			mobileNumber: $("#mobileNumber").val()
		}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "checkNumber",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(data) {
				if (data.status == "success") {
					$("#mobileNumberError").html("Mobile Number is already exists.");
				}
				else {
					hideMobileNumber();
				}
			},
			error: function(response) {
				if (response.responseText == "mobileNumberException") {
					$("#mobileNumberError").html("Mobile Number is already exists.");
				} else {
					hideMobileNumber();
				}
			}
		});
	});
};

// Check email address is exist or not
function checkEmail() {
	$("#email").on("keyup blur change input", function() {
		var formData = {
			id: $("#customerid").val(),
			email: $("#email").val()
		}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "checkEmail",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(data) {
				if (data.status == "success") {
					$("#emailError").html("Email address is already exists.");
				}
				else {
					hideEmailId();
				}
			},
			error: function(response) {
				if (response.responseText == "emailException") {
					$("#emailError").html("Email address is already exists.");
				} else {
					hideEmailId();
				}
			}
		});
	});
}
// Form validation using jQuery
$(function() {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var validAddress = /^[a-zA-Z0-9\s,.'-]{3,}$/;
	$.validator.addMethod("checkLower", function(value) {
		return /[a-z]/.test(value);
	});
	$.validator.addMethod("checkUpper", function(value) {
		return /[A-Z]/.test(value);
	});
	$.validator.addMethod("checkDigit", function(value) {
		return /[0-9]/.test(value);
	});
	$.validator.addMethod("checkAddres", function(value) {
		return validAddress.test(value);
	});
	$.validator.addMethod("checkString", function(value) {
		return /[A-Za-z]/.test(value);
	});
	$.validator.addMethod("checkStringNumber", function(value) {
		return /[A-Za-z0-9]/.test(value);
	});
	$.validator.addMethod("noSpace", function(value) {
		return value.indexOf(" ") < 0 && value != "";
	}, "No space please and don't leave it empty");
	$.validator.addMethod("checkEmail", function(value) {
		return mailformat.test(value);
	});
	$("#frmCustomer").validate({
		rules: {
			firstName: {
				noSpace: true,
				required: true,
				checkString: true
			},
			lastName: {
				noSpace: true,
				required: true,
				checkString: true
			},
			email: {
				noSpace: true,
				required: true,
				checkEmail: true
			},
			text: {
				required: true
			},
			DOB: {
				noSpace: true,
				required: true
			},
			addressOne: {
				required: true
			},
			addressTwo: {
				required: true
			},
			mobileNumber: {
				noSpace: true,
				required: true,
				checkDigit: true,
				minlength: 10
			},
		},
		messages: {
			firstName: {
				required: "Please provide first name.",
				checkString: "First name field accept only characters."
			},
			lastName: {
				required: "Please provide last name.",
				checkString: "Last name field accept only characters."
			},
			email: {
				required: "Please provide a email address.",
				checkEmail: "Please provide valid email address."
			},
			DOB: {
				required: "Please provide a date of birth."
			},
			addressOne: {
				required: "Please provide a present address."
			},
			addressTwo: {
				required: "Please provide a permanent address."
			},
			mobileNumber: {
				required: "Please provide a mobile number.",
				checkDigit: "Mobile number field accept only numbers/numeric value.",
				minlength: "Mobile number field accept only 10 number/numeric values."
			}
		},
		highlight: function(element) {
			var id_attr = "#" + $(element).attr("id") + "-error";
			$(element).closest('.signup-box').removeClass('has-success').addClass('has-error');
			$(id_attr).removeClass('validate_rem').addClass('errorMessage');
		},
		unhighlight: function(element) {
			var id_attr = "#" + $(element).attr("id") + "-error";
			$(element).closest('.signup-box').removeClass('has-error').addClass('has-success');
			$(id_attr).removeClass('errorMessage').addClass('validate_rem');
		},
		errorClass: 'errorMessage',
		errorPlacement: function(error, element) {
			x = element.length;
			if (element.length) {
				error.insertAfter(element);
			} else {
				error.insertAfter(element);
			}
		},
		submitHandler: function() {
			saveOrUpdateCustomer();
		}
	});
});

// Reset form 
function resetForm() {
	$("#customerid").val(""),
		$("#firstName").val(""),
		$("#lastName").val(""),
		$("#DOB").val(""),
		$("#mobileNumber").val(""),
		$("#addressOne").val(""),
		$("#addressTwo").val(""),
		$('#gender').prop('checked', false),
		$("#Age").val(""),
		$("#email").val(""),
		$('#save').val("Register Now")
};

// Save or update customer data.
function saveOrUpdateCustomer() {
	var formData = {
		id: $("#customerid").val(),
		firstName: $("#firstName").val(),
		lastName: $("#lastName").val(),
		dateOfBirth: $("#DOB").val(),
		mobileNumber: $("#mobileNumber").val(),
		presentAddress: $("#addressOne").val(),
		permanentAddress: $("#addressTwo").val(),
		age: $("#Age").val(),
		gender: $("input[name='gender']:checked").val(),
		email: $("#email").val()
	}
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "saveOrUpdateCustomer",
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(data) {
			if (data.status == "success") {
				Swal.fire('',
					'Customer data inserted successfully!',
					'success');
				resetForm();
				getAllCustomers();
			} else if (data.status == "update") {
				Swal.fire({
					icon: 'success',
					title: 'Update.',
					text: 'Customer data updated successfully!'
				});
				resetForm();
				getAllCustomers();
				$('#gender').prop('checked', false);
			} else {
				Swal.fire({
					icon: 'error',
					title: 'Oops...',
					text: 'Something went wrong!'
				});
				resetForm();
				getAllCustomers();
			}
		},
		error: function(response) {
			if (response.responseText == "mobileNumberException") {
				Swal.fire({
					icon: 'error',
					title: 'Oops',
					text: 'Mobile number already exist..'
				});
			} else if (response.responseText == "emailException") {
				Swal.fire({
					icon: 'error',
					title: 'Oops',
					text: 'Email address already exist.'
				});
			} else {
				Swal.fire({
					icon: 'error',
					title: 'Internal server error.',
					text: 'sorry for inconvenience!'
				});
			}
		}
	});
};

// Get all data from the database
function getAllCustomers() {
	$('#table-customer').DataTable().destroy();
	var tableData = '';
	$.ajax({
		type: "GET",
		url: "getAllCustomers",
		success: function(data) {
			data.forEach(function(item) {
				if (item.gender == 1) {
					item.gender = "Male";
				} else if (item.gender == 2) {
					item.gender = "Female";
				} else {
					item.gender = "Other";
				}
				if (item.dateOfBirth == "" || item.dateOfBirth == null) {
					item.dateOfBirth = "Update Your DOB";
				} else {
					item.dateOfBirth
				}
				tableData += '<tr>' +
					'<td id = "name' + item.id + '">' + item.firstName + " " + item.lastName + '</td>' +
					'<td id = "dob' + item.id + '">' + item.dateOfBirth + '</td>' +
					'<td id = "mobileNumber' + item.id + '">' + item.mobileNumber + '</td>' +
					'<td id = "address' + item.id + '">' + item.presentAddress + " " + item.permanentAddress + '</td>' +
					'<td id = "gender' + item.id + '">' + item.gender + '</td>' +
					'<td>' +
					'<button class="btn-success" id = "editButton' + item.id + '" style = "display:block;" onclick="editCustomer(' + item.id + ')">Edit</button>' +
					'<button class="btn-danger" onclick="deleteCustomer(' + item.id + ')">Delete</button></td>' +
					+'</tr>';
			});
			$('#tbl-cusData').html(tableData);
			$('#table-customer').DataTable();
		},
		error: function(e) {
			$("#getResultDiv").html("<strong>Error</strong>");
			console.log("ERROR: ", e);
		}
	});
};

// This function used for fetch selected customer data
function editCustomer(id) {
	remvoeAndResetForm();
	$('#save').val("Update Data");
	let url = 'getCustomerById/' + id;
	$.ajax({
		type: "GET",
		url: url,
		success: function(data) {
			$('#customerid').val(data.id);
			$('#firstName').val(data.firstName);
			$('#lastName').val(data.lastName);
			$('#DOB').val(data.dateOfBirth);
			$('#mobileNumber').val(data.mobileNumber);
			$('#addressOne').val(data.presentAddress);
			$('#addressTwo').val(data.permanentAddress);
			$('#Age').val(data.age);
			$(document.frmCustomer.gender.value = data.gender);
			$('#email').val(data.email);
		},
		error: function() {
			Swal.fire({
				icon: 'error',
				title: 'Oops...',
				text: 'Something went wrong!'
			});
		},
	});
};

// Delete customer data
function deleteCustomer(id) {
	Swal.fire({
		title: 'Are you sure want delete this?',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, delete it!',
	}).then((result) => {
		if (result['isConfirmed']) {
			Swal.fire({
				title: 'Deleted!',
				text: 'Customer deleted successfully!',
				icon: 'success'
			}).then(function() {
				let url = 'deleteCustomer/' + id;
				$.ajax({
					type: "POST",
					url: url,
					success: function() {
						remvoeAndResetForm();
						$('#gender').prop('checked', false);
					},
					error: function() {
						Swal.fire({
							icon: 'error',
							title: 'Oops...',
							text: 'Something went wrong!'
						});
					},
				});
			});
		} else {
			remvoeAndResetForm();
			Swal.fire("Cancelled", "Customer data is safe :)", "error");
			$('#gender').prop('checked', false);
		}
	});
};