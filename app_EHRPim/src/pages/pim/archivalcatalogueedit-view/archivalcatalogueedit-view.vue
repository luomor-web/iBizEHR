<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVALCATALOGUEEditViewBase from './archivalcatalogueedit-view-base.vue';

import view_form from '@widgets/pim-archival-catalogue/main-form/main-form.vue';

/**
 * 档案类别编辑视图
 *
 * @export
 * @class ARCHIVALCATALOGUEEditView
 * @extends {ARCHIVALCATALOGUEEditViewBase}
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
export default class ARCHIVALCATALOGUEEditView extends ARCHIVALCATALOGUEEditViewBase { }
</script>