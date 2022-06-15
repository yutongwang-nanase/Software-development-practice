import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [

	{
		path:"/",
		name:"Login",
		component: ()=> import ("../views/Login.vue")
	},

  {
	  path:"/homeview",
	  name:"home",
	  component: ()=> import ("../views/HomeView.vue"),
	  meta:{keepAlive:true}

  },


	{
		path: '/shangpin',
		name: 'Shangpin',
		component: ()=> import ("../views/shangpin.vue"),

	},
	{
		path: '/checkout',
		name: 'Checkout',
		component: ()=> import ("../views/checkout"),

	},





	{
		path:"/register",
		name:"Register",
		component: ()=> import ("../views/Register.vue")
	},

	{
		path:"/shop",
		name:"Shop",
		component: ()=> import ("../views/shop.vue"),

	},
	{
		path:"/car",
		name:"Car",
		component: ()=> import ("../views/car.vue"),

	},
	{
		path:"/fake",
		name:"Fake",
		component: ()=> import ("../views/other/fake.vue"),

	},
	{
		path:"/fakeshop",
		name:"Fakeshop",
		component: ()=> import ("../views/other/fakeshop.vue"),

	},
	{
		path:"/fakecar",
		name:"Fakecar",
		component: ()=> import ("../views/other/fakecar.vue"),

	},
	{
		path:"/right",
		name:"Right",
		component: ()=> import ("../components/Right"),

	},




	{
		path:'/message',
		name: 'Message',
		component: ()=> import ("../views/main/message.vue"),

	},
	{
		path:'/history',
		name: 'History',
		component: ()=> import ("../views/main/history.vue"),

	},
	{
		path:"/recharge",
		name:"Recharge",
		component: ()=> import ("../views/main/recharge"),

	},

]

const router = new VueRouter({
	mode: 'history',
  	base: process.env.BASE_URL,
  	routes
})

export default router
