<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionRedirectViewBase from './pim-distirbution-redirect-view-base.vue';


/**
 * 分配信息数据重定向视图
 *
 * @export
 * @class PimDistirbutionRedirectView
 * @extends {PimDistirbutionRedirectViewBase}
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
export default class PimDistirbutionRedirectView extends PimDistirbutionRedirectViewBase { }
</script>