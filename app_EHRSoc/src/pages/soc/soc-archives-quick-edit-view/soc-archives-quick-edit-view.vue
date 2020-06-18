<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesQuickEditViewBase from './soc-archives-quick-edit-view-base.vue';

import view_form from '@widgets/soc-archives/main2-form/main2-form.vue';

/**
 * 社保档案编辑视图
 *
 * @export
 * @class SocArchivesQuickEditView
 * @extends {SocArchivesQuickEditViewBase}
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
export default class SocArchivesQuickEditView extends SocArchivesQuickEditViewBase { }
</script>