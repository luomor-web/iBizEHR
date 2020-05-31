<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMFAMINFOEditViewBase from './pimfaminfoedit-view-base.vue';

import view_form from '@widgets/pim-faminfo/main-form/main-form.vue';

/**
 * 家庭情况编辑视图
 *
 * @export
 * @class PIMFAMINFOEditView
 * @extends {PIMFAMINFOEditViewBase}
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
export default class PIMFAMINFOEditView extends PIMFAMINFOEditViewBase { }
</script>