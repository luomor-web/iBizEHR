<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALWSSEditViewBase from './pimvocationalwssedit-view-base.vue';

import view_form from '@widgets/pim-vocational/main-3-form/main-3-form.vue';

/**
 * 证书信息编辑视图
 *
 * @export
 * @class PIMVOCATIONALWSSEditView
 * @extends {PIMVOCATIONALWSSEditViewBase}
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
export default class PIMVOCATIONALWSSEditView extends PIMVOCATIONALWSSEditViewBase { }
</script>