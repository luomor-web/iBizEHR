<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPersonAbilityRedirectViewBase from './pimperson-ability-redirect-view-base.vue';


/**
 * 员工能力数据重定向视图
 *
 * @export
 * @class PIMPersonAbilityRedirectView
 * @extends {PIMPersonAbilityRedirectViewBase}
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
export default class PIMPersonAbilityRedirectView extends PIMPersonAbilityRedirectViewBase { }
</script>