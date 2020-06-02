<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTYPECONTRACTEditViewBase from './pimtypecontractedit-view-base.vue';

import view_form from '@widgets/pim-type-contract/main-form/main-form.vue';

/**
 * 合同类型编辑视图
 *
 * @export
 * @class PIMTYPECONTRACTEditView
 * @extends {PIMTYPECONTRACTEditViewBase}
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
export default class PIMTYPECONTRACTEditView extends PIMTYPECONTRACTEditViewBase { }
</script>