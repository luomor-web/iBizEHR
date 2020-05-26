<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgRedirectViewBase from './orm-sign-org-redirect-view-base.vue';


/**
 * 法人主体数据重定向视图
 *
 * @export
 * @class OrmSignOrgRedirectView
 * @extends {OrmSignOrgRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class OrmSignOrgRedirectView extends OrmSignOrgRedirectViewBase { }
</script>