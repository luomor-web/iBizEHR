<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdgwEditViewBase from './sal-stdgw-edit-view-base.vue';

import view_form from '@widgets/sal-stdgw/main-form/main-form.vue';

/**
 * 高温津贴标准编辑视图
 *
 * @export
 * @class SalStdgwEditView
 * @extends {SalStdgwEditViewBase}
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
export default class SalStdgwEditView extends SalStdgwEditViewBase { }
</script>