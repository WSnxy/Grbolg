


/**
 * stastus : 0表示原创  1表示转载
 * title 标题
 * time 时间
 * content 文章内容
 * name 作者内容
 * comments  评论数量
 * browse 浏览数量
 * img 右侧图片
 */
var  vContent={
     props:{
        status:String,
        title:String,
        time:String,
        content:String,
        name:String,
        comments:Number,
        browse:Number,
        img:String,
     },
     template:'#contentItem'
}
/**
 * 分类列表项组件
 * url 地址
 */
var vType={
    props:{
        url:String,
        type:String,
        count:Number
    },
    template:'#typeItem'
}

var  vRecommend={
    props:{
        url:String,
      content:String
    },
    template:'#recommendItem'
}



 var vm=new Vue({
    el:'#content',
    data:{
        person:{
            status:'原',
            title:'Spring学习',
            time:'3分钟前',
            content:'学习Java必备框架xasxcsedcsa必备框',
            name:'ninghao',
            comments:100,
            browse:3000,
            img:'https://picsum.photos/id/1/250/150'
        }
    },
    components:{
        vContent,
        vType,
        vRecommend
    }
})
