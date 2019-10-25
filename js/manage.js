


// mg编辑组件
var  md={
    template:'#edit'
}
var routes=[
    {path:'/md',component:md}
];

const router = new VueRouter({
    routes
})

new Vue({
    el:'#container',
    router

})




