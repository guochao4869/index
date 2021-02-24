

let num = location.search.slice(15)
let classify = location.search.slice(10,11)
let arr = ["../img/product.jpg","../img/dress.jpg","../img/database.jpg" ]
let video = []
$(".img-box img").attr("src",arr[classify-1])
// 获取详情
console.log(classify)
axios.get(reqURL + "Goodsparticulars/GoodsDetails/findById/" + num).then(data => {
    if (data.data.result == null) {
        console.log("没有数据")
        return
    }
    // 产品信息
    let str = `
        <h2>${data.data.result.name}</h2>
        <div class="details">
            <img src="${reqURL}${data.data.result.img}" alt="">
            <div class="product-content">
                <h3>${data.data.result.smallname}
                    <span>${data.data.result.length}</span>
                </h3>
                <div class="product-matter">
                    <p>${data.data.result.result}</p>
                </div>
            </div>
        </div>`
    $(".product").html(str)

    // 产品展示
    let videoResultArr = data.data.result.video.split(";")
    let num = videoResultArr.some(val => {
        return val != ""
    })
    if (!num) {
        // 展示图片
        let imgArr = data.data.result.goodsshowimg.split(";")
        let imgStr = ``
        imgArr.forEach(val=>{
            imgStr += `<img src="${reqURL}${val}" controls></img>`
        })
        console.log(imgArr )
        let videoStr = `
                <h2>
                    <span>产品展示</span>
                </h2>
                <div class="video-box">
                    ${imgStr}
                </div>
                <div class="video-info">
                    产品介绍：<span>${data.data.result.showimgdescribe}</span>
                </div>
                `
        $(".product-video").html(videoStr)
    }
    else {
        // 展示视频
        videoResultArr.forEach((val, index) => {
            if (val == "") {
                video.push(val)
            }
            else {
                video.push(reqURL + val)
            }
        });
        let videoPath = video[0]
        if (video[0] == "") {
            videoPath = video[1]
        }
        let videoStr = `
                <h2>
                    <span>产品展示</span>
                    <button class="open" onclick='change(0)'">开启状态</button>
                    <button class="close" onclick='change(1)'>关闭状态</button>
                </h2>
                <div class="video-box">
                    <video class="video" src="${videoPath}" controls></video>
                </div>
                <div class="video-info">
                    视频介绍：<span>${data.data.result.videodescribe}</span>
                </div>
                `
        $(".product-video").html(videoStr)
    }
})

// 切换视频
let flag = 0
function change(index) {
    if (index != flag) {
        flag = index
        if (video[index] != "") {
            $(".video-box .video").attr("src", video[index])
        }
    }
}

