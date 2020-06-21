<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesEditViewBase from './soc-archives-edit-view-base.vue';

import view_form from '@widgets/soc-archives/main-form/main-form.vue';

/**
 * 社保档案编辑视图
 *
 * @export
 * @class SocArchivesEditView
 * @extends {SocArchivesEditViewBase}
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
export default class SocArchivesEditView extends SocArchivesEditViewBase { }
</script>