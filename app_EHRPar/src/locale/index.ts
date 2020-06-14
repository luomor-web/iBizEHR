import Vue from 'vue'
import VueI18n from 'vue-i18n'

const vueApp: any = Vue;

vueApp.use(VueI18n);

import zhCn from './lang/zh-CN';
import iviewZhCnLocale from 'view-design/dist/locale/zh-CN';
import elementZhLocale from 'element-ui/lib/locale/lang/zh-CN';

const messages = {
    'zh-CN': Object.assign(iviewZhCnLocale, elementZhLocale, zhCn),
};


// 自动根据浏览器系统语言设置语言
const navLang = localStorage.getItem('local') || navigator.language;
const localLang = (navLang === 'zh-CN' || (navLang === 'en-US' && messages.hasOwnProperty('en-US'))) ? navLang : false;
let lang: string = localLang || 'zh-CN';

vueApp.config.lang = lang

// // vue-i18n 6.x+写法
vueApp.locale = () => { };

const i18n = new VueI18n({
    locale: lang,
    messages,
    silentTranslationWarn:true
});

export default i18n;
