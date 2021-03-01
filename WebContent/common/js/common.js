window.addEventListener('load', ()=>{
    let htmlTag = document.querySelector('html');
    let themeBtn = document.querySelector('.theme');
    let icon = themeBtn.querySelector('i');

    let isOsColorTheme = window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light';
    let userColorTheme = localStorage.getItem('theme');
    console.log(localStorage.getItem('theme'))
    

    if(userColorTheme == 'dark'){
        darkMode();
    }else if(userColorTheme == 'light'){
        lightMode();
    }else {
        //처음들어왔을때는 os설정을 따름 / userCOlorTheme == null인경우
        if(isOsColorTheme == 'dark'){
            darkMode();
        } else if(isOsColorTheme == 'light'){
            lightMode();
        };
    }

    // 테마 셋팅
    function setTheme(themeName){
        localStorage.setItem('theme', themeName);
        userColorTheme = localStorage.getItem('theme');
    }
    
    themeBtn.addEventListener('click', ()=>{
        //테마 컬러는 storage컬러를 따름
        if(userColorTheme == 'light'){
            darkMode();
            
        } else if(userColorTheme == 'dark'){
            lightMode();
           
        }

    })

    function darkMode(){
        htmlTag.classList.add('dark_theme');
        icon.classList.remove('xi-sun');
        icon.classList.add('xi-night');
        setTheme('dark');
    }

    function lightMode(){
        htmlTag.classList.remove('dark_theme');
        icon.classList.remove('xi-night');
        icon.classList.add('xi-sun');
        setTheme('light');
    }
})