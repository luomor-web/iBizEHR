<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALCATALOGEditViewBase from './pimvocationalcatalogedit-view-base.vue';

import view_form from '@widgets/pim-vocational-catalog/main-form/main-form.vue';

/**
 * 职（执）业资格目录管理编辑视图
 *
 * @export
 * @class PIMVOCATIONALCATALOGEditView
 * @extends {PIMVOCATIONALCATALOGEditViewBase}
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
export default class PIMVOCATIONALCATALOGEditView extends PIMVOCATIONALCATALOGEditViewBase { }
</script>