<template>
    <div class='login'>
        <img src="/assets/img/background.png"/>

        <div class='login-con'>
            <card :bordered="false">
                <p slot='title' style="text-align: center">
                    &nbsp;&nbsp;{{appTitle}}
                </p>
                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item prop='loginname'>
                            <p>用户名</p>
                            <i-input
                                    size='large'
                                    prefix='ios-contact'
                                    v-model.trim="form.loginname"
                                    placeholder="用户名"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item prop='password'>
                            <p>密码</p>
                            <i-input
                                    size='large'
                                    prefix='ios-key'
                                    v-model.trim="form.password"
                                    type='password'
                                    placeholder="密码"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                    @click="handleSubmit"
                                    type='primary'
                                    class="login_btn">登录
                            </i-button>
                            <i-button
                                    @click="goReset"
                                    type='success'
                                    class="login_reset">重置
                            </i-button>
                        </form-item>

                        <form-item>
                            <div style="text-align: center">
                                <span class="form_tipinfo">其他登录方式</span>
                            </div>
                            <div style="text-align: center">
                                <div class="sign-btn" @click="tencentHandleClick('tencent')">
                                    <img src="/assets/img/QQ.svg" class="qq-svg-container" draggable="false">
                                </div>
                                <div class="sign-btn" @click="wechatHandleClick('wechat')">
                                    <img src="/assets/img/weixin.svg" class="wx-svg-container" draggable="false">
                                </div>
                            </div>
                        </form-item>

                    </i-form>
                    <p class='login-tip'>
                        {{this.loginTip}}
                        <!--{{this.$t('components.login.tip')}}-->
                    </p>
                </div>
            </card>
            <div class="log_footer">
                <div class="copyright">
                    <a href="https://www.ibizlab.cn/" target="_blank">{{appTitle}} is based on ibizlab .</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import {Vue, Component, Watch} from 'vue-property-decorator';
import {Environment} from '@/environments/environment';
//import Divider from "ibiz-vue-lib/lib/ibiz-vue-lib.common";

@Component({
    components: {}
})
export default class Login extends Vue {

    /**
     * 表单对象
     *
     * @type {*}
     * @memberof Login
     */
    public form: any = {loginname: 'guest', password: 'guest'};

    /**
     *　登录提示语
        */
    public loginTip: any = "";

    /**
     *　按钮可点击
        */
    public canClick: any = true;

    /**
     * 应用名称
     *
     * @type {string}
     * @memberof Login
     */
    public appTitle: string = Environment.AppTitle;

    /**
     * 值规则
     *
     * @type {*}
     * @memberof Login
     */
    public rules = {};

    /**
     * 设置值规则
     *
     * @memberof Login
     */
    public setRules() {
        this.rules = {
            loginname: [
                {required: true, message: this.$t('components.login.loginname.message'), trigger: 'change'},
            ],
            password: [
                {required: true, message: this.$t('components.login.password.message'), trigger: 'change'},
            ],
        }
    };

    /**
     * 生命周期Create
     *
     * @memberof Login
     */
    public created() {
        this.setRules();
    }

    public mounted() {
        this.getCookie("loginname");
    }

    /**
     * 监听语言变化
     *
     * @memberof Login
     */
    @Watch('$i18n.locale')
    onLocaleChange(newval: any, val: any) {
        this.setRules();
    }

    /**
     * 登陆处理
     *
     * @memberof Login
     */
    public handleSubmit(): void {
        // 清除cookie
        let leftTime = new Date();
        leftTime.setTime(leftTime.getSeconds() - 1000);
        document.cookie = "ibzuaa-token=;expires=" + leftTime.toUTCString();
        const form: any = this.$refs.loginForm;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        if (!validatestate) {
            return;
        }

        const loginname: any = this.form.loginname;
        const password: any = this.form.password;
        const post: Promise<any> = this.$http.post('v7/login', this.form, true);
        post.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                if (data && data.token) {
                    localStorage.setItem('token', data.token);
                    this.setCookie('ibzuaa-token',data.token,0);
                }
                // 设置cookie,保存账号密码7天
                this.setCookie("loginname",loginname, 7);
                // 跳转首页
                const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                this.$router.push({path: url});
            }
        }).catch((error: any) => {
            // 登录提示
            const data = error.data;
            if (data && data.message) {
                this.loginTip = data.message;
                this.$Message.error({
                    content: "登录失败，" + data.message,
                    duration: 5,
                    closable: true
                });
            } else {
                this.$Message.error({
                    content: "登录失败",
                    duration: 5,
                    closable: true
                });
            }
        });

    }

    /**
     * 重置页面
     * 
     * @memberof Login
     */
    public goReset(): void {
        const _this = this;
        _this.form={loginname: 'ibzadmin', password: '123456'}
    }

    /**
     * 设置cookie
     * 
     * @memberof Login
     */
    public setCookie(name: any, value: any, day: any) {
            if (day !== 0) { //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
                let curDate = new Date();
                let curTamp = curDate.getTime();
                let curWeeHours = new Date(curDate.toLocaleDateString()).getTime() - 1;
                let passedTamp = curTamp - curWeeHours;
                let leftTamp = 24 * 60 * 60 * 1000 - passedTamp;
                let leftTime = new Date();
                leftTime.setTime(leftTamp + curTamp);
                document.cookie = name + "=" + escape(value) + ";expires=" + leftTime.toUTCString();
            } else {
                document.cookie = name + "=" + escape(value);
            }
    }

    /**
     * 获取cookie
     * 
     * @memberof Login
     */
    public getCookie(name: any): any {
            let arr;
            let reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return null;
    }

    /**
     * qq授权登录
     * @param thirdpart
     */
    public tencentHandleClick(thirdpart: any) {
        this.$Message.warning("qq授权登录暂未支持")
    }

    /**
     * 微信授权登录
     * @param thirddpart
     */
    public wechatHandleClick(thirddpart: any) {
        this.$Message.warning("微信授权登录暂未支持")
    }

}
</script>

<style lang='less'>
    @import './login.less';
</style>