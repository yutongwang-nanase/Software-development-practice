import router from "./index.js"

router.beforeEach((to,from,next) =>{
	if(to.meta.isLogin){
		let token = false;
		if(token){
			next();
		}else{		
			next({
				name:"Login"
			})
		}
	}else{
		next();
	}
})