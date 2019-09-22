app.service('userService',function($http){
	var BASE_URL = "http://localhost:8080/user-demo/";
	
	this.findUserList=function(){
		return $http.get(BASE_URL+'getAllUserList');
	}
	
	this.findByPage=function(pageNum,pageSize){
		return $http.get(BASE_URL + 'getUserPage?pageNum=' + pageNum + '&pageSize=' + pageSize);
	}
	
	this.addUser=function(user){
		return $http.post(BASE_URL + 'addUser', user);
	}
		
	this.updateUser=function(user){
		return $http.post(BASE_URL + 'updateUser', user);
	}
	
	this.findUserById=function(user_id){
		return $http.get(BASE_URL + "getUserById?id=" + user_id)
	}
	
	this.deleteUser=function(ids){
		return $http.get(BASE_URL + 'deleteUserByIds?ids=' + ids);
	}
});