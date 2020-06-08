<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALGREditViewBase from './pimvocationalgredit-view-base.vue';

import view_form from '@widgets/pim-vocational/main-2-form/main-2-form.vue';

/**
 * 证书信息编辑视图
 *
 * @export
 * @class PIMVOCATIONALGREditView
 * @extends {PIMVOCATIONALGREditViewBase}
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
export default class PIMVOCATIONALGREditView extends PIMVOCATIONALGREditViewBase { }
</script>