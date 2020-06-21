<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxkhxhzEditViewBase from './par-jxkhxhz-edit-view-base.vue';

import view_form from '@widgets/par-jxkhxhz/main-form/main-form.vue';

/**
 * 考核方案编辑视图
 *
 * @export
 * @class ParJxkhxhzEditView
 * @extends {ParJxkhxhzEditViewBase}
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
export default class ParJxkhxhzEditView extends ParJxkhxhzEditViewBase { }
</script>