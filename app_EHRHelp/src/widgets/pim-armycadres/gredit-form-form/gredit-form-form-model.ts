/**
 * GREditForm 部件模型
 *
 * @export
 * @class GREditFormModel
 */
export default class GREditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GREditFormModel
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
        prop: 'pimarmycadresid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimarmycadresname',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'trooptype',
        prop: 'trooptype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'leveltype',
        prop: 'leveltype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fssj',
        prop: 'fssj',
        dataType: 'DATE',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'pimarmycadresid',
        prop: 'pimarmycadresid',
        dataType: 'GUID',
      },
      {
        name: 'pimarmycadres',
        prop: 'pimarmycadresid',
        dataType: 'FONTKEY',
      },
    ]
  }

}