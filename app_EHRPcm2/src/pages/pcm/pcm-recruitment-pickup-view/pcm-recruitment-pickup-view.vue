<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmRecruitmentPickupViewBase from './pcm-recruitment-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-recruitment/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 内部招聘信息数据选择视图
 *
 * @export
 * @class PcmRecruitmentPickupView
 * @extends {PcmRecruitmentPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmRecruitmentPickupView extends PcmRecruitmentPickupViewBase { }
</script>