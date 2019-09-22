app.controller('userController',function($scope,userService){
	
	$scope.findUserList=function(){
		userService.findUserList().success(function(response){
			$scope.userList=response;
		})
	}
	
	$scope.paginationConf = {
		currentPage: 1,
		totalItems: 5,
		itemsPerPage: 2,
		perPageOptions: [2, 5, 10],
		onChange: function() {
			$scope.reloadList();
		}
	};
	
	$scope.reloadList = function() {
		$scope.findByPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
	}
	
	$scope.findByPage = function(pageNum, pageSize) {
		userService.findByPage(pageNum, pageSize).success(function(response) {
			$scope.userList = response.rows;
			$scope.paginationConf.totalItems = response.total;
		});
	}
	
	$scope.findOne = function(User_id) {
		userService.findUserById(User_id).success(function(response) {
			$scope.entity = response;
		});
	}
	
	
	$scope.checkedIds = [];
	
	$scope.updateCheck = function(event, User_id) {
		if(event.target.checked == true) {
			$scope.checkedIds.push(User_id);
		} else {
			var index = $scope.checkedIds.indexOf(User_id);
			$scope.checkedIds.splice(index, 1);
		}
	
	}
	
	$scope.save = function() {
		var serviceObj=null;
		if($scope.entity.id != null) {
			serviceObj=userService.updateUser($scope.entity);
		}else{
			serviceObj=userService.addUser($scope.entity);
		}	
		serviceObj.success(function(response) {
			if(response.success) {
				$scope.reloadList();
			} else {
				alert(response.msg);
			}
		});
	}
	
	$scope.dele = function() {
		if(!$scope.checkedIds.length > 0) {
			alert('请选择！');
		} else {
			if(confirm('是否删除？')) {
				userService.deleteUser($scope.checkedIds).success(function(response) {
					if(response.success) {
						$scope.reloadList();
					} else {
						alert(response.msg);
					}
				});
			}
		}
	}
	
});