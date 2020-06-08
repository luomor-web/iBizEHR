/**
 * GRPatentEditForm 部件模型
 *
 * @export
 * @class GRPatentEditFormModel
 */
export default class GRPatentEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GRPatentEditFormModel
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
        prop: 'pimpatentid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpatentname',
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
        name: 'zlh',
        prop: 'zlh',
        dataType: 'TEXT',
      },
      {
        name: 'pimpatentname',
        prop: 'pimpatentname',
        dataType: 'TEXT',
      },
      {
        name: 'zlpzgb',
        prop: 'zlpzgb',
        dataType: 'TEXT',
      },
      {
        name: 'zlhqsj',
        prop: 'zlhqsj',
        dataType: 'DATE',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'enclolure',
        prop: 'enclolure',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimpatentid',
        prop: 'pimpatentid',
        dataType: 'GUID',
      },
      {
        name: 'pimpatent',
        prop: 'pimpatentid',
        dataType: 'FONTKEY',
      },
    ]
  }

}