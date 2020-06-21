<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParAssessTemplatePickupViewBase from './par-assess-template-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/par-assess-template/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考核模板数据选择视图
 *
 * @export
 * @class ParAssessTemplatePickupView
 * @extends {ParAssessTemplatePickupViewBase}
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
export default class ParAssessTemplatePickupView extends ParAssessTemplatePickupViewBase { }
</script>