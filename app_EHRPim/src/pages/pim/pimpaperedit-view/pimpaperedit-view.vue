<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPEREditViewBase from './pimpaperedit-view-base.vue';

import view_form from '@widgets/pim-paper/main-form/main-form.vue';

/**
 * 论文信息编辑视图
 *
 * @export
 * @class PIMPAPEREditView
 * @extends {PIMPAPEREditViewBase}
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
export default class PIMPAPEREditView extends PIMPAPEREditViewBase { }
</script>