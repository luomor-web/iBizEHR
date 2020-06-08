<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMFAMINFOGREditViewBase from './pimfaminfogredit-view-base.vue';

import view_form from '@widgets/pim-faminfo/main-2-form/main-2-form.vue';

/**
 * 家庭情况编辑视图
 *
 * @export
 * @class PIMFAMINFOGREditView
 * @extends {PIMFAMINFOGREditViewBase}
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
export default class PIMFAMINFOGREditView extends PIMFAMINFOGREditViewBase { }
</script>