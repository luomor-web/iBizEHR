import { Vue, Component } from 'vue-property-decorator';
import './app-user-info.less';

/**
 * 用户信息展示
 *
 * @export
 * @class AppUserInfo
 * @extends {Vue}
 */
@Component({})
export class AppUserInfo extends Vue {

    /**
     * 用户名 
     *
     * @memberof AppUserInfo
     */
    public username = "埃";

    /**
     * vue  生命周期
     *
     * @memberof AppUserInfo
     */
    public mounted() {
        if(this.$store.getters.getAppData()){
            if(this.$store.getters.getAppData().context && this.$store.getters.getAppData().context.srfusername){
              let _username = this.$store.getters.getAppData().context.srfusername;
              this.username = _username.substr(0,1).toUpperCase();
            }
        }
    }

    /**
     * 下拉选选中回调
     *
     * @param {*} data
     * @memberof AppUserInfo
     */
    public userSelect(data: any) {
        if (Object.is(data, 'logout')) {
            const title: any = this.$t('components.appUser.surelogout');
            this.$Modal.confirm({
                title: title,
                onOk: () => {
                    this.logout();
                }
            });
        }
    }

    /**
     * 退出登录
     *
     * @memberof AppUserInfo
     */
    public logout() {
        const get: Promise<any> = this.$http.get('v7/logout');
        get.then((response:any) =>{
            if (response && response.status === 200) {
                localStorage.removeItem('user');
                localStorage.removeItem('token');
                let leftTime = new Date();
                leftTime.setTime(leftTime.getSeconds() - 1);
                document.cookie = "ibzuaa-token=;expires=" + leftTime.toUTCString();
                this.$router.push({ name: 'login' });
            }
        }).catch((error: any) =>{
            console.error(error);
        })
    }

    /**
     * 绘制用户信息内容
     *
     * @returns {*}
     * @memberof AppUserInfo
     */
    public render(): any {
        return <div class="crm-app-user-info">
          <dropdown on-on-click={this.userSelect} transfer={true}>
            <div class="user-head-sculpture">
                {this.username}
            </div>
            <span>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAUCAYAAACqJ5zlAAAAN0lEQVQoU2PsmLzCk5Hh/0wGBgaG/wyM6Yydk5c/+s/AIAsSYGRgeIwpgKEFpBQZMJIhMIzcAQAhOjo7JEcKTQAAAABJRU5ErkJggg=="></img>
            </span>
            <dropdown-menu class='menu' slot='list' style='font-size: 15px !important;'>
                <dropdown-item name='logout' style='font-size: 15px !important;'>
                    <span><i aria-hidden='true' class='fa fa-cogs' style='margin-right: 8px;'></i></span>
                    <span>{this.$t('components.appUser.logout')}</span>
                </dropdown-item>
            </dropdown-menu>
          </dropdown>
        </div>;
    }

}