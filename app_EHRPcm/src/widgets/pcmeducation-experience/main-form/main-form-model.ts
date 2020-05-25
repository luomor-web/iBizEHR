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
        prop: 'pcmeducationexperienceid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmeducationexperiencename',
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
        name: 'xl',
        prop: 'xl',
        dataType: 'SSCODELIST',
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
        name: 'schoolname',
        prop: 'schoolname',
        dataType: 'TEXT',
      },
      {
        name: 'xkml',
        prop: 'xkml',
        dataType: 'SSCODELIST',
      },
      {
        name: 'majorname',
        prop: 'majorname',
        dataType: 'TEXT',
      },
      {
        name: 'xxxz',
        prop: 'xxxz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'formsoflearning',
        prop: 'formsoflearning',
        dataType: 'SSCODELIST',
      },
      {
        name: 'firstxl',
        prop: 'firstxl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'higestxl',
        prop: 'higestxl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'byz',
        prop: 'byz',
        dataType: 'TEXT',
      },
      {
        name: 'xwz',
        prop: 'xwz',
        dataType: 'TEXT',
      },
      {
        name: 'xlyz',
        prop: 'xlyz',
        dataType: 'TEXT',
      },
      {
        name: 'pcmeducationexperienceid',
        prop: 'pcmeducationexperienceid',
        dataType: 'GUID',
      },
      {
        name: 'pcmeducationexperience',
        prop: 'pcmeducationexperienceid',
        dataType: 'FONTKEY',
      },
    ]
  }

}