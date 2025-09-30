<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vue.js</title>
</head>
<body>

<div id="example">
  <p>원본 메시지: "{{ message }}"</p>
  <p>역순으로 표시한 메시지: "{{ reversedMessage }}"</p>
</div>

<div id="demo">{{ fullName }}</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">

	var vm1 = new Vue({
		el : '#example',
		data : {
			message : '안녕하세요'
		},
		computed : {
			// 계산된 getter
			reversedMessage : function() {
				// `this` 는 vm 인스턴스를 가리킵니다.
				return this.message.split('').reverse().join('')
			},
			c_now : function() {
				return Date.now()
			}
		},
		methods : {
			f_now : function() {
				return Date.now()
			}
		}
	})

	var vm2 = new Vue({
		el : '#demo',
		data : {
			firstName : 'Foo',
			lastName : 'Bar',
			fullName : 'Foo Bar'
		},
		watch : {
			firstName : function(val) {
				this.fullName = val + ' ' + this.lastName
			},
			lastName : function(val) {
				this.fullName = this.firstName + ' ' + val
			}
		}
	})
	
</script>
</html>