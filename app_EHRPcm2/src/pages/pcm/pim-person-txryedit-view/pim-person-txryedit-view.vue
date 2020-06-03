<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonTXRYEditViewBase from './pim-person-txryedit-view-base.vue';

import view_form from '@widgets/pim-person/txedit-form-form/txedit-form-form.vue';

/**
 * 退休人员信息
 *
 * @export
 * @class PimPersonTXRYEditView
 * @extends {PimPersonTXRYEditViewBase}
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
export default class PimPersonTXRYEditView extends PimPersonTXRYEditViewBase { }
</script>