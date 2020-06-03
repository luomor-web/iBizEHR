/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmpracticeexperienceid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmpracticeexperiencename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pcmprofileid',
        prop: 'pcmprofileid',
        dataType: 'PICKUP',
      },
      {
        name: 'practicecompanyname',
        prop: 'practicecompanyname',
        dataType: 'TEXT',
      },
      {
        name: 'starttime',
        prop: 'starttime',
        dataType: 'DATE',
      },
      {
        name: 'endtime',
        prop: 'endtime',
        dataType: 'DATE',
      },
      {
        name: 'sxgw',
        prop: 'sxgw',
        dataType: 'TEXT',
      },
      {
        name: 'practicecontent',
        prop: 'practicecontent',
        dataType: 'TEXT',
      },
      {
        name: 'sxpj',
        prop: 'sxpj',
        dataType: 'TEXT',
      },
      {
        name: 'pcmpracticeexperienceid',
        prop: 'pcmpracticeexperienceid',
        dataType: 'GUID',
      },
      {
        name: 'pcmpracticeexperience',
        prop: 'pcmpracticeexperienceid',
        dataType: 'FONTKEY',
      },
    ]
  }

}