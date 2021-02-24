
let  num = location.search.slice(4)
// 获取列表
function getList(index) {
    axios.get(reqURL + "Journalism/findAllPage/" + index).then(data => {
        let reg = /\<.+?\>/g
        let listStr = ``
        // 列表内容
        data.data.result.list.forEach(val => {
            val.result = val.result.replace(reg, "")
            listStr += `
                <li >
                    <a href="newInfo.html?id=${ val.details_id}">
                        <div class="pic">
                            <img src="${reqURL}${val.img}" alt="">
                        </div>
                        <div class="news">
                            <div class="news-title">${ val.name}<span>${val.time}</span></div>
                            <div class="news-info">${ val.result}</div>
                            <div class="news-btn">查看详情</div>
                        </div>
                    </a>
                </li>`
        });
        $(".news-list").html(listStr)

        // 分页
        let pageNum = data.data.result.pages
        $(".page").pagination({
            pageURL:"news.html",
            currentPage: parseInt(data.data.result.pageNum),
            totalPages: pageNum,
            param:"id"
        })
        // // 输入值
        let jump = document.querySelector(".pg-jumpNum");
        jump.oninput = function () {
            this.onkeydown = function (e) {
                if (event.keyCode === 13) {
                    let val = parseInt($(".pg-jumpNum").val())
                    if (val) {
                        if (val > pageNum) {
                            val = pageNum
                        }
                        getList(val)
                    }
                }
            }
        }
        // 确认按钮
        $(".pg-jumpBtn").on("click", function () {
            let val = parseInt($(".pg-jumpNum").val())
            if (val) {
                if (val > pageNum) {
                    val = pageNum
                }
                getList(val)
            }
        })
    })
}
getList(num)

