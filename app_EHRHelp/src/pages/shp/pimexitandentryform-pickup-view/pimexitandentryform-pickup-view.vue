<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYFormPickupViewBase from './pimexitandentryform-pickup-view-base.vue';


/**
 * 出入境管理数据选择视图
 *
 * @export
 * @class PIMEXITANDENTRYFormPickupView
 * @extends {PIMEXITANDENTRYFormPickupViewBase}
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
export default class PIMEXITANDENTRYFormPickupView extends PIMEXITANDENTRYFormPickupViewBase { }
</script>