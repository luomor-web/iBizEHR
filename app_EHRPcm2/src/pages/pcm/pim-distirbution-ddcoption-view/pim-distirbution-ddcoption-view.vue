<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionDDCOptionViewBase from './pim-distirbution-ddcoption-view-base.vue';

import view_form from '@widgets/pim-distirbution/ddcoption-form-form/ddcoption-form-form.vue';

/**
 * 调出
 *
 * @export
 * @class PimDistirbutionDDCOptionView
 * @extends {PimDistirbutionDDCOptionViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PimDistirbutionDDCOptionView extends PimDistirbutionDDCOptionViewBase { }
</script>