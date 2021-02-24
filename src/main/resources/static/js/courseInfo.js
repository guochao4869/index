

    let num = location.search.slice(4)
    axios.get( reqURL + "ActivityContent/findActivityContent/" + num  ).then(data=>{
        let reg = /(\<span.+?\>)|(\<\/span\>)/g
        let content = data.data.result.content.replace(reg ,"" )
        let str = `
                <div class="text-tlt">
                    <h2>${  data.data.result.title } </h2>
                    <p> <span>活动时间 :&nbsp; ${ data.data.result.starttime }</span>
                    </p>  		
                </div>
                <div class="text-box"> ${ content } </div>
                `

        $( ".container" ).html( str )
    })