<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPERGREditViewBase from './pimpapergredit-view-base.vue';

import view_form from '@widgets/pim-paper/gredit-form-form/gredit-form-form.vue';

/**
 * 论文信息编辑视图
 *
 * @export
 * @class PIMPAPERGREditView
 * @extends {PIMPAPERGREditViewBase}
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
export default class PIMPAPERGREditView extends PIMPAPERGREditViewBase { }
</script>