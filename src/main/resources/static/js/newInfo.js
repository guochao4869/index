
let num = parseInt(location.search.slice(4))

// 获取详情
axios.get(reqURL + "JournalismContent/findById/" + num).then(data => {
    if (data.data.result == null) {
        console.log("没有数据")
        return
    }
    let reg = /(\<span.+?\>)|(\<\/span\>)/g
    let content = data.data.result.content.replace(reg, "")
    let str = `
                <div class="text-tlt">
                    <h2>${data.data.result.name}</h2>
                    <p><span>文章来源 ：&nbsp;${data.data.result.source}</span> <span>发布时间 :&nbsp; ${data.data.result.time}</span>
                    </p>  		
                </div>
                <div class="text-box">${ content}</div>`
    $(".container").html(str)
})