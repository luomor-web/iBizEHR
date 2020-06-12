<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPersonAbilityDetailRedirectViewBase from './pimperson-ability-detail-redirect-view-base.vue';


/**
 * 员工能力明细数据重定向视图
 *
 * @export
 * @class PIMPersonAbilityDetailRedirectView
 * @extends {PIMPersonAbilityDetailRedirectViewBase}
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
export default class PIMPersonAbilityDetailRedirectView extends PIMPersonAbilityDetailRedirectViewBase { }
</script>