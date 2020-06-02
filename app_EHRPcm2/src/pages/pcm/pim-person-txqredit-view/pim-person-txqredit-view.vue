<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonTXQREditViewBase from './pim-person-txqredit-view-base.vue';

import view_form from '@widgets/pim-person/txqredit-form-form/txqredit-form-form.vue';

/**
 * 请确认/修改退休信息
 *
 * @export
 * @class PimPersonTXQREditView
 * @extends {PimPersonTXQREditViewBase}
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
export default class PimPersonTXQREditView extends PimPersonTXQREditViewBase { }
</script>