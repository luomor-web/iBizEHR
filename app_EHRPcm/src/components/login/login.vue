<template>
    <div class='login'>
        <div class='login-con'>
            <card :bordered="false">
                <p slot='title'>
                    <icon type='ios-log-in'></icon>
                    &nbsp;&nbsp;{{this.$t('components.login.caption')}}
                </p>
                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item prop='loginname'>
                            <i-input
                                prefix='ios-contact'
                                v-model="form.loginname"
                                :placeholder="this.$t('components.login.loginname.placeholder')">
                            </i-input>
                        </form-item>
                        <form-item prop='password'>
                            <i-input
                                prefix='ios-key'
                                v-model="form.password"
                                type='password'
                                :placeholder="this.$t('components.login.password.placeholder')">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                @click="handleSubmit"
                                type='primary'
                                long>
                                {{this.$t('components.login.name')}}
                            </i-button>
                        </form-item>
                    </i-form>
                    <p class='login-tip'>
                        {{this.$t('components.login.tip')}}
                    </p>
                </div>
            </card>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Watch } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';

@Component({
})
export default class Login extends Vue {

    /**
     * 表单对象
     *
     * @type {*}
     * @memberof Login
     */
    public form: any = { loginname: null, password: null };

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
    public setRules(){
        this.rules = {
          loginname: [
              { required: true, message: this.$t('components.login.loginname.message'), trigger: 'change' },
          ],
          password: [
              { required: true, message: this.$t('components.login.password.message'), trigger: 'change' },
          ],
        }
    };

    /**
     * 生命周期Create
     *
     * @memberof Login
     */
    public created(){
        this.setRules();
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
        const form: any = this.$refs.loginForm;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        if (!validatestate) {
            return;
        }
        const post: Promise<any> = this.$http.post('v7/login', this.form, true);
        post.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                localStorage.setItem('token', data.token);
                localStorage.setItem('user', JSON.stringify(data.user));
                const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                this.$router.push({ path: url });
            }
        }).catch((error: any) => {
            const loginfailed: any = this.$t('components.login.loginfailed');
            this.$Notice.error({ title: (this.$t('components.login.error') as any), desc: loginfailed });
        });

    }

}
</script>

<style lang='less'>
@import './login.less';
</style>